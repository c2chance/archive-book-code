package com.activiti.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class CreateTable {
	
	/****
	 * 创建流程表
	 * */
	@Test
	public void createTable() {
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine();
		
		System.out.println("------processEngine:" + processEngine); 
	}
	
	@Test
	public void deployFlow() {
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine	();
		Deployment deployment = processEngine.getRepositoryService().createDeployment().name("hello")
				.addClasspathResource("diagrams/HelloWorld.bpmn").addClasspathResource("diagrams/HelloWorld.png").deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());	
	}
	
	@Test
	public void flowStart() {
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine	();
		RuntimeService runtimeService =processEngine.getRuntimeService();
		
		Map<String, Object> variables = new HashMap<String, Object>(); 
	    variables.put("hello", "wangbo");
		ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("HelloWorldKey", "666", variables);
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getProcessDefinitionId());
		
		
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ProcessDefinition  processDefinition = repositoryService.getProcessDefinition(processInstance.getProcessDefinitionId());
		System.out.println(processDefinition.getId());
		System.out.println(processDefinition.getKey());

	}
	
	@Test
	public void findTask() {
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine	();
		TaskService  taskService = processEngine.getTaskService();
		List<Task> taskList = taskService.createTaskQuery().taskAssignee("张三").list();
	
		if(taskList !=null && taskList.size()>0){
			for (Task task : taskList) {
				System.out.println(task.getAssignee());
				//推向下一环节
				Map<String, Object> variables = taskService.getVariables(task.getId());  
				processEngine.getTaskService().complete(task.getId(),variables);
			}
		}

	}
	
	
	@Test
	public void completeTask() {
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
				.buildProcessEngine	();
		String taskId = "10002";
		processEngine.getTaskService().complete(taskId);

	}
}


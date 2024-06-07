package com.manage.report.action;



import java.io.InputStream;
import java.io.FileInputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CardInssuerSaveAction extends ActionSupport {

    private static final long serialVersionUID = 1656950476675155655L;
    private String md5;
    private String filename;
    private String directory;

    @Override
    public String execute() throws Exception {
        //这里进行参数验证，保证请求的下载文件合法性
        // 本例对传入参数md5进行验证并将其值赋予filename
        if (md5.matches("[\\w&&[^_]]{32}?")) {
            filename = md5.toLowerCase();
            return SUCCESS;
        }
        return INPUT;
    }

    public InputStream getInputStream() throws Exception {
        String dir = directory + filename + ".txt";
        return new FileInputStream(dir);    //如果dir是绝对路径
//        return ServletActionContext.getServletContext().getResourceAsStream(dir);    //如果dir是Resource下的相对路径
    }

    /**
     * @return the md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5
     *            the md5 to set
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     *            the filename to set
     */
    public void setFilename(String filename) {
        this.filename = this.getMd5();
    }

    /**
     * @param directory
     *            the directory to set
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

}
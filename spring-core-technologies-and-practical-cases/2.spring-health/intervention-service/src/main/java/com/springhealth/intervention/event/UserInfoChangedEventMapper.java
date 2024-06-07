package com.springhealth.intervention.event;

import com.springhealth.intervention.client.UserMapper;

public class UserInfoChangedEventMapper{
    private String type;
    private String action;
    private UserMapper user;

    public UserInfoChangedEventMapper(){
        super();
    }

    public UserInfoChangedEventMapper(String type, String action, UserMapper user) {
        super();
        this.type   = type;
        this.action = action;
        this.user = user;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

	public UserMapper getUser() {
		return user;
	}

	public void setUser(UserMapper user) {
		this.user = user;
	}

	@Override
    public String toString() {
        return "UserInfoChangedEventMapper [type=" + type +
                ", action=" + action +
                ", userId="  + user.getId() +"]";
    }
}

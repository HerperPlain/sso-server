package com.honglu.crm.dict.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sc_system_dict")
public class SystemDictEntity implements Serializable{
    @Id
    @Column(name = "dictionary_id")
    private String systemDictId;
    @Column(name = "code")
    private String code ;
    @Column(name = "value")
    private String value;
    @Column(name = "parent")
    private int parent;
    @Column(name = "state")
    private int  state;

    public String getSystemDictId() {
        return systemDictId;
    }

    public void setSystemDictId(String systemDictId) {
        this.systemDictId = systemDictId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public SystemDictEntity(String systemDictId, String code, String value, int parent, int state) {
        this.systemDictId = systemDictId;
        this.code = code;
        this.value = value;
        this.parent = parent;
        this.state = state;
    }

    public SystemDictEntity() {
    }

    @Override
    public String toString() {
        return "SystemDictEntity{" +
                "systemDictId='" + systemDictId + '\'' +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", parent=" + parent +
                ", state=" + state +
                '}';
    }
}

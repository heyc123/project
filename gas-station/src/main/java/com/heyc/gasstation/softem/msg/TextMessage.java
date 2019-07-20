package com.heyc.gasstation.softem.msg;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@Data
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextMessage {
    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    @XmlElement(name = "CreateTime")
    private String createTime;
    @XmlElement(name = "MsgType")
    private String msgType;
    @XmlElement(name = "Content")
    private String Content;
    @XmlElement(name = "MsgId")
    private String msgId;

}

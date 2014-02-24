package no.nith.pg6100.domain;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class BaseTimestampedObject implements Serializable{
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date modifiedTimestamp;


    public  BaseTimestampedObject() {
        this.modifiedTimestamp=new java.util.Date();
    }

    public Date getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(Date modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }
}

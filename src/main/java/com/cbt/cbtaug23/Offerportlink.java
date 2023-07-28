package com.cbt.cbtaug23;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offerportlinks")
public class Offerportlink {
    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "offerid", length = 10)
    private String offerid;

    @Column(name = "portid", length = 10)
    private String portid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }

    public String getPortid() {
        return portid;
    }

    public void setPortid(String portid) {
        this.portid = portid;
    }

}
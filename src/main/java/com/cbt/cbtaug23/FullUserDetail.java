package com.cbt.cbtaug23;

import java.util.List;

public class FullUserDetail
{
    Userdetail detail;
    List<Usertypelink> link;

    public List<Usertypelink> getLink() {
        return link;
    }

    public Userdetail getDetail() {
        return detail;
    }

    public void setDetail(Userdetail detail) {
        this.detail = detail;
    }

    public void setLink(List<Usertypelink> link) {
        this.link = link;
    }
}

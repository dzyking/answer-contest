package com.answer.contest.entity;

import javax.persistence.*;

@Table(name = "g_group")
public class GGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "ticket_num")
    private Integer ticketNum;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ticket_num
     */
    public Integer getTicketNum() {
        return ticketNum;
    }

    /**
     * @param ticketNum
     */
    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", ticketNum=").append(ticketNum);
        sb.append("]");
        return sb.toString();
    }
}
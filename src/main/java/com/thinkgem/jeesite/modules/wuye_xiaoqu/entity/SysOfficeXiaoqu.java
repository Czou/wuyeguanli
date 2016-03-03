/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wuye_xiaoqu.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 小区信息管理Entity
 * @author ktzhxm
 * @version 2016-03-02
 */
public class SysOfficeXiaoqu extends DataEntity<SysOfficeXiaoqu> {
	
	private static final long serialVersionUID = 1L;
	private SysOfficeXiaoqu parent;		// 父级编号
	private String name;		// 名称
	private String sort;		// 排序
	private String code;		// 区域编码
	private String type;		// 机构类型
	private String grade;		// 机构等级
	private String address;		// 联系地址
	private Integer renshu;		// 公司人数
	private String zipCode;		// 邮政编码
	private User master;		// 负责人
	private String phone;		// 电话
	private String fax;		// 传真
	private String email;		// 邮箱
	private String useable;		// 是否启用
	private Integer loudongshu;		// 楼栋数
	private Integer hushu;		// 户数
	private Integer cheweishu;		// 车位数
	private Date jiansherq;		// 建设日期
	private Double jianzhupm;		// 建筑平米
	private Double gonggongpm;		// 建筑平米
	private Double lvhuapm;		// 绿化面积
	private Double daolupm;		// 道路面积
	private Double chekupm;		// 车库平米
	
	public SysOfficeXiaoqu() {
		super();
	}

	public SysOfficeXiaoqu(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public SysOfficeXiaoqu getParent() {
		return parent;
	}

	public void setParent(SysOfficeXiaoqu parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=100, message="区域编码长度必须介于 0 和 100 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=1, max=1, message="机构类型长度必须介于 1 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=1, max=1, message="机构等级长度必须介于 1 和 1 之间")
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Length(min=0, max=255, message="联系地址长度必须介于 0 和 255 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getRenshu() {
		return renshu;
	}

	public void setRenshu(Integer renshu) {
		this.renshu = renshu;
	}
	
	@Length(min=0, max=100, message="邮政编码长度必须介于 0 和 100 之间")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public User getMaster() {
		return master;
	}

	public void setMaster(User master) {
		this.master = master;
	}
	
	@Length(min=0, max=200, message="电话长度必须介于 0 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=200, message="传真长度必须介于 0 和 200 之间")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=0, max=200, message="邮箱长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=1, max=64, message="是否启用长度必须介于 1 和 64 之间")
	public String getUseable() {
		return useable;
	}

	public void setUseable(String useable) {
		this.useable = useable;
	}
	
	public Integer getLoudongshu() {
		return loudongshu;
	}

	public void setLoudongshu(Integer loudongshu) {
		this.loudongshu = loudongshu;
	}
	
	public Integer getHushu() {
		return hushu;
	}

	public void setHushu(Integer hushu) {
		this.hushu = hushu;
	}
	
	public Integer getCheweishu() {
		return cheweishu;
	}

	public void setCheweishu(Integer cheweishu) {
		this.cheweishu = cheweishu;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getJiansherq() {
		return jiansherq;
	}

	public void setJiansherq(Date jiansherq) {
		this.jiansherq = jiansherq;
	}
	
	public Double getJianzhupm() {
		return jianzhupm;
	}

	public void setJianzhupm(Double jianzhupm) {
		this.jianzhupm = jianzhupm;
	}
	
	public Double getGonggongpm() {
		return gonggongpm;
	}

	public void setGonggongpm(Double gonggongpm) {
		this.gonggongpm = gonggongpm;
	}
	
	public Double getLvhuapm() {
		return lvhuapm;
	}

	public void setLvhuapm(Double lvhuapm) {
		this.lvhuapm = lvhuapm;
	}
	
	public Double getDaolupm() {
		return daolupm;
	}

	public void setDaolupm(Double daolupm) {
		this.daolupm = daolupm;
	}
	
	public Double getChekupm() {
		return chekupm;
	}

	public void setChekupm(Double chekupm) {
		this.chekupm = chekupm;
	}
	
}
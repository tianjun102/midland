package com.huixin.web.model;

public class NoticeWithBLOBs extends Notice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.role_ids
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    private String roleIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.user_ids
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    private String userIds;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.role_ids
     *
     * @return the value of notice.role_ids
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.role_ids
     *
     * @param roleIds the value for notice.role_ids
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.user_ids
     *
     * @return the value of notice.user_ids
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    public String getUserIds() {
        return userIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.user_ids
     *
     * @param userIds the value for notice.user_ids
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }
    
    
    public Integer  isViewed ;

	public Integer getIsViewed() {
		return isViewed;
	}

	public void setIsViewed(Integer isViewed) {
		this.isViewed = isViewed;
	}
    
    
}
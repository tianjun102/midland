package com.huixin.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.web.model.Notice;
import com.huixin.web.model.NoticeExample;
import com.huixin.web.model.NoticeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int countByExample(NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int deleteByExample(NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int insert(NoticeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int insertSelective(NoticeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    List<NoticeWithBLOBs> selectByExampleWithBLOBs(NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    List<Notice> selectByExample(NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    NoticeWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int updateByExampleSelective(@Param("record") NoticeWithBLOBs record, @Param("example") NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int updateByExampleWithBLOBs(@Param("record") NoticeWithBLOBs record, @Param("example") NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int updateByPrimaryKeySelective(NoticeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(NoticeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated Tue Feb 14 14:27:03 CST 2017
     */
    int updateByPrimaryKey(Notice record);

	PageList<NoticeWithBLOBs> selectByExampleWithBLOBs(NoticeExample example, PageBounds pageBounds);
}
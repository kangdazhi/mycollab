package com.esofthead.mycollab.common.dao;

import com.esofthead.mycollab.common.domain.RelayEmailNotification;
import com.esofthead.mycollab.common.domain.RelayEmailNotificationExample;
import com.esofthead.mycollab.core.persistence.ICrudGenericDAO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelayEmailNotificationMapper extends ICrudGenericDAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int countByExample(RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int deleteByExample(RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int insert(RelayEmailNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int insertSelective(RelayEmailNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    List<RelayEmailNotification> selectByExampleWithBLOBs(RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    List<RelayEmailNotification> selectByExample(RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    RelayEmailNotification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int updateByExampleSelective(@Param("record") RelayEmailNotification record, @Param("example") RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int updateByExampleWithBLOBs(@Param("record") RelayEmailNotification record, @Param("example") RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int updateByExample(@Param("record") RelayEmailNotification record, @Param("example") RelayEmailNotificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int updateByPrimaryKeySelective(RelayEmailNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int updateByPrimaryKeyWithBLOBs(RelayEmailNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    int updateByPrimaryKey(RelayEmailNotification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    Integer insertAndReturnKey(RelayEmailNotification value);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    void removeKeysWithSession(List primaryKeys);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_relay_email_notification
     *
     * @mbggenerated Thu Apr 03 11:05:05 ICT 2014
     */
    void massUpdateWithSession(@Param("record") RelayEmailNotification record, @Param("primaryKeys") List primaryKeys);
}
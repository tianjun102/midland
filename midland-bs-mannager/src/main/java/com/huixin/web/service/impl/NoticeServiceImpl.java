package com.huixin.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericDao;
import com.huixin.core.generic.GenericServiceImpl;
import com.huixin.core.util.DateUtils;
import com.huixin.web.dao.NoticeMapper;
import com.huixin.web.model.Notice;
import com.huixin.web.model.NoticeExample;
import com.huixin.web.model.NoticeExample.Criteria;
import com.huixin.web.model.NoticeWithBLOBs;
import com.huixin.web.service.NoticeService;

@Service
public class NoticeServiceImpl extends GenericServiceImpl<Notice, Long> implements NoticeService {

	@Resource
    private NoticeMapper noticeMapper;
	
	
	@Override
	public List<Notice> selectList() {
		// TODO Auto-generated method stub
		NoticeExample example=new NoticeExample();
		noticeMapper.selectByExample(example);
		return null;
	}

	@Override
	public GenericDao<Notice, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeWithBLOBs> selectNoticeList(Notice notice) {
		
		PageBounds pageBounds=new PageBounds(1,3);//取3条
		
		NoticeExample example=new NoticeExample();
		Criteria criteria =example.createCriteria();
		example.setOrderByClause("send_time desc");//发送时间倒叙
		if(notice != null){
			if(StringUtils.isNotEmpty(notice.getTitle())){
				criteria.andTitleEqualTo(notice.getTitle());
			}
			if(notice.getMsgType()!=null){
				criteria.andMsgTypeEqualTo(notice.getMsgType());
			}
			if(StringUtils.isNotEmpty(notice.getTitle())){
				criteria.andTitleEqualTo(notice.getTitle());
			}
			if(notice.getIsSend()!=null){
				criteria.andIsSendEqualTo(notice.getIsSend());
			}
			
			if(StringUtils.isNotEmpty(notice.getSendTime1())){
				criteria.andSendTimeGreaterThanOrEqualTo(DateUtils.parseStringToDateYYMMDD(notice.getSendTime1()));
			}
			if(StringUtils.isNotEmpty(notice.getSendTime2())){
				criteria.andSendTimeLessThanOrEqualTo(DateUtils.parseStringToDateYYMMDD(notice.getSendTime2()));
			}
			if(notice.getIsDelete()!=null){
				criteria.andIsDeleteEqualTo(notice.getIsDelete());
			}
		}
		List<NoticeWithBLOBs> list=noticeMapper.selectByExampleWithBLOBs(example,pageBounds);
		return list;
	}

	@Override
	public PageList<NoticeWithBLOBs> selectByExampleAndPage(Notice notice, PageBounds pageBounds) {
		NoticeExample example=new NoticeExample();
		Criteria criteria =example.createCriteria();
		example.setOrderByClause("is_top desc,send_time desc,creat_time desc");
		if(notice != null){
			if(StringUtils.isNotEmpty(notice.getTitle())){
				criteria.andTitleLike("%"+notice.getTitle()+"%");
			}
			if(notice.getMsgType()!=null){
				criteria.andMsgTypeEqualTo(notice.getMsgType());
			}
			if(notice.getIsSend()!=null){
				criteria.andIsSendEqualTo(notice.getIsSend());
			}
			if(notice.getIsDelete()!=null){
				criteria.andIsDeleteEqualTo(notice.getIsDelete());
			}
			if(StringUtils.isNotEmpty(notice.getSendTime1())){
				criteria.andSendTimeGreaterThanOrEqualTo(DateUtils.parseStringToDateYYMMDD(notice.getSendTime1()));
			}
			if(StringUtils.isNotEmpty(notice.getSendTime2())){
				criteria.andSendTimeLessThanOrEqualTo(DateUtils.parseStringToDateYYMMDD(notice.getSendTime2()));
			}
			
		}
		PageList<NoticeWithBLOBs> list=noticeMapper.selectByExampleWithBLOBs(example,pageBounds);
		return list;
	}

	@Override
	public int addNotice(NoticeWithBLOBs notices) {
		notices.setCreatTime(new Date());
		notices.setIsDelete(0);
		notices.setIsTop(0);
		if(notices.getIsSend()==null){
			notices.setIsSend(0);
		}
		
		return noticeMapper.insert(notices);
	}

	@Override
	public NoticeWithBLOBs findNoticeById(Integer id) {
		return noticeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateNotice(NoticeWithBLOBs notices) {
		return noticeMapper.updateByPrimaryKeySelective(notices);
	}

	@Override
	public int top(Integer noticeId) {
		NoticeWithBLOBs record=new NoticeWithBLOBs();
		record.setIsTop(0);
		NoticeExample example=new NoticeExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsTopEqualTo(1);
		criteria.andIdNotEqualTo(noticeId);
		noticeMapper.updateByExampleSelective(record, example);//先把数据库是置顶的改为不置顶
		
		record.setId(noticeId);
		record.setIsTop(1);
		noticeMapper.updateByPrimaryKeySelective(record);//置顶该条数据
		
		return 1;
	}

}

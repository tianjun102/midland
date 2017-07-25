package com.huixin.web.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.huixin.core.generic.GenericService;
import com.huixin.web.model.Notice;
import com.huixin.web.model.NoticeWithBLOBs;

public interface NoticeService extends GenericService<Notice, Long> {

	/**
	 * 首页头部公告通知查询
	 * @param notice
	 * @return
	 */
	List<NoticeWithBLOBs> selectNoticeList(Notice notice);

	/**
	 * 列表分页查询
	 * @param notice
	 * @param pageBounds
	 * @return
	 */
	PageList<NoticeWithBLOBs> selectByExampleAndPage(Notice notice, PageBounds pageBounds);
	
	int addNotice(NoticeWithBLOBs notices);
	
	
	NoticeWithBLOBs findNoticeById(Integer id);
	
	int updateNotice(NoticeWithBLOBs notices);

	int top(Integer noticeId);
}

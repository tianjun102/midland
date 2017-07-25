package com.huixin.web.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.huixin.web.service.OrderInfoService;
import com.huixin.web.service.ProductService;

@Component("taskJob")
public class TaskJob {

	@Resource
	private ProductService productService;

	@Resource
	private OrderInfoService orderInfoService;

	
	// 商品定时上架
	@Scheduled(cron = "0 */1 * * * ?") //每一分钟调用一次 
	public void job1() {
		System.out.println("================== 开始商品定时上架任务  =======================");
		productService.changeProdStatus();
		System.out.println("================== 结束商品定时上架任务  =======================");
	}

	
	// 订单支付超时 自动关闭
	@Scheduled(cron = "0 0 */1 * * ?")  //每一个小时调用一次  
	public void job2() {
		System.out.println("================== 开始关闭超时订单任务  =======================");
		orderInfoService.changeOrderStatus();
		System.out.println("================== 结束关闭超时订单任务  =======================");
	}
	
	// 订单收货超时 自动关闭
	@Scheduled(cron = "0 0 12 * * ?")  //每天中午12点调用  
	public void job3() {
		System.out.println("================== 开始超时确认收货订单自动完成任务  =======================");
		orderInfoService.changeOrderComplete();
		System.out.println("================== 结束超时确认收货订单自动完成任务  =======================");
	}
	
}

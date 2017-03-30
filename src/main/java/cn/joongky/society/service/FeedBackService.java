package cn.joongky.society.service;

import cn.joongky.society.pojo.Feedback;

public interface FeedBackService {
	
	Feedback add(String feedBackId,String content,String operatorId);
	
	Feedback findById(String feedbackId);
}

package cn.joongky.society.service.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import cn.joongky.society.dao.FeedbackMapper;
import cn.joongky.society.pojo.Feedback;
import cn.joongky.society.service.FeedBackService;

@Service("feedBackService")
public class FeedBackServiceImpl implements FeedBackService{
	@Inject 
	private FeedbackMapper fbMapper;

	@Override
	public Feedback add(String feedBackId, String content, String operatorId) {
		Feedback fb = new Feedback();
		Date now = new Date();
		fb.setFeedbackId(feedBackId);
		fb.setOperatorId(operatorId);
		fb.setFbTime(now);
		fb.setContent(content);
		fbMapper.insertSelective(fb);
		return fbMapper.selectByPrimaryKey(feedBackId);
	}

	@Override
	public Feedback findById(String feedbackId) {
		return fbMapper.selectByPrimaryKey(feedbackId);
	}
	
	
}

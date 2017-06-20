package com.softwareproject;

import java.util.List;
import java.util.Set;

/**
 * @ClassName: Teachers
 * @Description: TODO
 * @author 邓再再
 * @date 2016年10月26日 下午5:58:50
 *
 */
public class Teachers extends User {
	private List<Topics> _topicIds; // 教师发布的题目
	private String _dept; // 教师的系别
	private Set<Students> _studentIds; // 教师的指导学生

	

	/**
	 * 
	 * @Title: issueTopics
	 * @Description: 发布批量题目
	 * @param _topics
	 * @return void
	 * @throws
	 */
	public void issueTopics(List<Topics> _topicIds) {

	}

	/**
	 * 
	 * @Title: issueTopic
	 * @Description: 发布单一题目
	 * @param _topicId
	 * @return void
	 * @throws
	 */
	public void issueTopic(Topics _topicId) {

	}

	/**
	 * 
	 * @Title: updateTopic
	 * @Description: 更新题目信息
	 * @param _topicId
	 * @return void
	 * @throws
	 */
	public void updateTopic(Topics _topicId) {

	}

	/**
	 * 
	 * @Title: deteleTopic
	 * @Description: 删除题目
	 * @param _topicId
	 * @return void
	 * @throws
	 */
	public void deteleTopic(Topics _topicId) {

	}

	/**
	 * 
	 * @Title: queryTopics
	 * @Description: 查询发布的题目
	 * @param _teacherId
	 * @return void
	 * @throws
	 */
	public void queryTopics(Teachers _teacherId) {

	}

	/**
	 * 
	 * @Title: query_chooseTopicCondition
	 * @Description: 查询单一的题目被选择的情况
	 * @param _topicId
	 * @return void
	 * @throws
	 */
	public void query_chooseTopicCondition(Topics _topicId) {

	}

	/**
	 * 
	 * @Title: query_chooseTopicCondition
	 * @Description: 查询批量的题目被选择的情况
	 * @param _topicsId
	 * @return void
	 * @throws
	 */
	public void query_chooseTopicCondition(List<Topics> _topicsId) {

	}
}

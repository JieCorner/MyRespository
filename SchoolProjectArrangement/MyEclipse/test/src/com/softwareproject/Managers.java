package com.softwareproject;

import java.util.List;

/**
 * @ClassName: Managers
 * @Description: TODO
 * @author 邓再再
 * @date 2016年10月26日 下午5:58:55
 *
 */
public class Managers extends User {
	/**
	 * 
	 * @Title: reviewTopics
	 * @Description: 审核教师提交的题目
	 * @param _teacherId
	 * @return void
	 * @throws
	 */
	private int ManagersId;
	private String ManagersName;
	private String Password;
	
	public void reviewTopics(Teachers _teacherId) {

	}

	/**
	 * 
	 * @Title: submitTopics
	 * @Description: 发布教师的题目
	 * @param _teacherId
	 * @return void
	 * @throws
	 */
	public void submitTopics(Teachers _teacherId) {

	}

	/**
	 * 
	 * @Title: submitTopics
	 * @Description: 发布批量的题目
	 * @param _topicIds
	 * @return void
	 * @throws
	 */
	public void submitTopics(List<Topics> _topicIds) {

	}

	/**
	 * 
	 * @Title: inputStudentScore
	 * @Description: 录入学生的毕设成绩
	 * @param _studentId
	 * @return void
	 * @throws
	 */
	public void inputStudentScore(Students _studentId) {

	}

	/**
	 * 
	 * @Title: query_chooseTopicCondition
	 * @Description: 查询老师的题目被选择情况
	 * @param _teacherId
	 * @return void
	 * @throws
	 */
	public void query_chooseTopicCondition(Teachers _teacherId) {

	}

	/**
	 * 
	 * @Title: query_chooseTopicCondition
	 * @Description: 查询学生选择的题目情况
	 * @param _studentId
	 * @return void
	 * @throws
	 */
	public void query_chooseTopicCondition(Students _studentId) {

	}
}

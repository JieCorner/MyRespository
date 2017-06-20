package com.softwareproject;

import java.util.List;

/**
 * @ClassName: Courses
 * @Description: TODO
 * @author 邓再再
 * @date 2016年10月26日 下午5:58:57
 *
 */
public class Topics {
	private String _id; // 题目的Id
	private String _name; // 题目的名称
	private String _description; // 题目的表述
	private int _numOfStudent; // 题目可被多少人数的学生选择
	private List<Students> _studentsId; // 选择题目的学生
	private Teachers _teacherId; // 出题目的老师

	

}

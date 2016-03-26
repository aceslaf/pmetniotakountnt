package com.startsmart.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.startsmart.model.dao.RightDao;
import com.startsmart.model.pojo.Right;

import io.undertow.attribute.RequestMethodAttribute;

@Controller
public class RightsController {

	@Autowired
	RightDao rightsDao;

	@RequestMapping(value = "/getRightById/{rightId}", method = RequestMethod.GET)
	@ResponseBody
	public Right getEmployeeById(@PathVariable int rightId) {

		Right right = null;
		try {
			right = rightsDao.getRightById(rightId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return right;
	}
	
	@RequestMapping(value = "/insertNewRight", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void insertNewRight(@RequestBody Right right) {
		try {
			rightsDao.insertNewRight(right);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/modifyRight/{rightId}/{rightName}", method = RequestMethod.GET)
	@ResponseBody
	public Right modifyRight(@PathVariable int rightId, @PathVariable String rightName) {
		Right modifiedRight = null;
		try {
			modifiedRight = rightsDao.modifyRight(rightId,rightName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modifiedRight;
	}
	
	@RequestMapping(value = "/deleteRight/{rightId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteRight(@PathVariable int rightId) {
		try {
			rightsDao.deleteRight(rightId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

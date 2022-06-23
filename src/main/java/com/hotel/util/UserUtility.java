package com.hotel.util;

import com.hotel.exception.UserException;
import com.hotel.pojo.User;

public class UserUtility {

	public void validateUser(User user) {

		if (isEmptyOrNull(user.getName(), 1)) {
			throw new UserException("Name should not be empty.");
		}

		if (isEmptyOrNull(user.getUserName(), 1)) {
			throw new UserException("User Name should not be empty.");
		}

		if (isEmptyOrNull(user.getPassword(), 1)) {
			throw new UserException("Password should not be empty.");
		}

		if (isEmptyOrNull(user.getMobileNo(), 1)) {
			throw new UserException("Mobile No should not be empty.");
		}

		if (isEmptyOrNull(user.getEmailId(), 1)) {
			throw new UserException("Email Id should not be empty.");
		}

	}

	public boolean isEmptyOrNull(Object obj, Integer objectType) {
		boolean isEmptyOrNull = true;
		switch (objectType) {
		case 1:
			String x = (String) obj;
			if (x.isEmpty() || x.isBlank()) {
				isEmptyOrNull = true;
			} else {
				isEmptyOrNull = false;
			}
			break;

		}

		return isEmptyOrNull;

	}

}

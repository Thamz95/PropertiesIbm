package com.aditi.insight.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aditi.insight.auth.jwt.PasswordHashService;
import com.aditi.insight.domain.User;
import com.aditi.insight.dto.models.UserDTO;
import com.aditi.insight.exception.InsightException;
import com.aditi.insight.repository.UserRepository;
import com.aditi.insight.utils.ErrorHandler;

@Service
public class UserService extends AbstractService<User, Long> {

	private UserRepository userRepository;

	@Autowired
	private DTOToDomainConverstionService dTOToDomainConverstionService;

	@Autowired
	private PasswordHashService passwordHashService;

	@Autowired
	public UserService(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}

	/********************
	 * To get user by id*
	 ********************
	 * @param id
	 * @return
	 * @throws InsightException
	 */
	public User getUser(long id) throws InsightException {
		if (!exists(id))
			throw new InsightException(ErrorHandler.USER_NOT_EXIST, ErrorHandler.ID_NOT_EXIST);
		else
			return userRepository.findOne(id);
	}

	/*********************************
	 * To check email is exist or not*
	 *********************************
	 * @param email
	 * @return
	 */
	public boolean isEmailExist(String email) {
		return userRepository.findByEmailIgnoreCase(email) == null ? false : true;
	}

	/**********************************
	 * To check mobile is exist or not*
	 **********************************
	 * @param mobile
	 * @return
	 */
	public boolean isMobileExist(String mobile) {
		return userRepository.findByMobile(mobile) == null ? false : true;
	}

	public boolean isMobileExist(long id, String mobile) {
		User user = userRepository.findByMobile(mobile);

		if (user != null) {
			if (user.getId() == id && user.getMobile().equals(mobile)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/***********************
	 * To get user by email*
	 ***********************
	 * @param email
	 * @return
	 * @throws InsightException
	 */
	public User getUser(String email) throws InsightException {
		User user = userRepository.findByEmailIgnoreCase(email);
		if (user != null)
			return user;
		else
			throw new InsightException(ErrorHandler.USER_NOT_EXIST, ErrorHandler.ID_NOT_EXIST);

	}

	/*************************************
	 * To check email is exist or not*****
	 *************************************
	 * @param id
	 * @param email
	 * @return
	 */
	public boolean isEmailExist(long id, String email) {
		User user = userRepository.findByEmailIgnoreCase(email);

		if (user != null) {
			if (user.getId() == id && user.getEmail().equals(email)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/*******************************
	 * To get current loggedIn User*
	 *******************************
	 * @return
	 * @throws InsightException
	 */
	public User getLoggedinUser() throws InsightException {
		final String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = getUser(email);
		return user;

	}

	/*******************
	 * To get all users*
	 *******************
	 * @return
	 * @throws InsightException
	 */
	public List<User> getUser() throws InsightException {
		return findAll();
	}

	/******************
	 * To get All user*
	 ******************
	 * @param pageable
	 * @return
	 */
	public Page<User> getAllUsers(Pageable pageable) {
		return findAll(pageable);
	}

	/**************
	 * To add user*
	 **************
	 * @param userDTO
	 * @return
	 * @throws InsightException
	 */
	public User addUser(UserDTO userDTO) throws InsightException {
		if (userDTO == null)
			throw new InsightException(ErrorHandler.DTO_CAN_NOT_EMPTY, ErrorHandler.DTO_CAN_NOT_NULL);

		if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty())
			throw new InsightException(ErrorHandler.EMAIL_REQUIRED, ErrorHandler.EMAIL_CAN_NOT_NULL);

		if (isEmailExist(userDTO.getEmail()))
			throw new InsightException(ErrorHandler.EMAIL_ALREADY_EXIST, ErrorHandler.EMAIL_EXIST);

		if (userDTO.getMobile() != null) {
			if (!userDTO.getMobile().isEmpty() && isMobileExist(userDTO.getEmail()))
				throw new InsightException(ErrorHandler.PHONE_REQUIRED, ErrorHandler.PHONE_MISSING);
		}

		if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty())
			throw new InsightException(ErrorHandler.PASSWORD_REQUIRED, ErrorHandler.PASSWORD_CAN_NOT_NULL);

		try {
			User user = dTOToDomainConverstionService.convertUser(userDTO);
			return save(user);
		} catch (Exception e) {
			throw new InsightException(ErrorHandler.USER_ADD_FAILED, ErrorHandler.ADD_FAILED, e);
		}
	}

	/*****************
	 * To update user*
	 *****************
	 * @param id
	 * @param userDTO
	 * @return
	 * @throws InsightException
	 */
	@Transactional
	public User updateUser(long id, UserDTO userDTO) throws InsightException {

		if (!exists(id))
			throw new InsightException(ErrorHandler.USER_NOT_EXIST, ErrorHandler.ID_NOT_EXIST);

		if (userDTO == null)
			throw new InsightException(ErrorHandler.DTO_CAN_NOT_EMPTY, ErrorHandler.DTO_CAN_NOT_NULL);

		if (userDTO.getEmail() == null || userDTO.getEmail().isEmpty())
			throw new InsightException(ErrorHandler.EMAIL_REQUIRED, ErrorHandler.EMAIL_CAN_NOT_NULL);

		if (isEmailExist(id, userDTO.getEmail()))
			throw new InsightException(ErrorHandler.EMAIL_ALREADY_EXIST, ErrorHandler.EMAIL_EXIST);

		if (userDTO.getMobile() != null) {
			if (!userDTO.getMobile().isEmpty() && isMobileExist(id, userDTO.getMobile()))
				throw new InsightException(ErrorHandler.PHONE_ALREADY_EXIST, ErrorHandler.PHONE_EXIST);
		}

		if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty())
			throw new InsightException(ErrorHandler.PASSWORD_REQUIRED, ErrorHandler.PASSWORD_CAN_NOT_NULL);

		try {
			User updateUser = getUser(id);
			updateUser.setName(userDTO.getName());
			updateUser.setEmail(userDTO.getEmail());
			updateUser.setJoinedStatus(userDTO.getJoinedStatus());
			updateUser.setMobile(userDTO.getMobile());
			updateUser.setUserRole(userDTO.getUserRole());
			updateUser=save(updateUser);
			return updateUser;
		} catch (Exception e) {
			throw new InsightException(ErrorHandler.USER_NOT_UPDATED, ErrorHandler.UPDATE_FAILED, e);
		}
	}

	/*****************
	 * To delete User*
	 *****************
	 * @param id
	 * @return
	 * @throws InsightException
	 */
	@Transactional
	public Boolean deleteUser(long id) throws InsightException {
		Boolean isDeleted = false;
		if (!exists(id))
			throw new InsightException(ErrorHandler.USER_NOT_EXIST, ErrorHandler.ID_NOT_EXIST);
		try {
			delete(id);
			isDeleted = !exists(id);
			return isDeleted;
		} catch (Exception e) {
			throw new InsightException(ErrorHandler.USER_DELETE_FAIELD, ErrorHandler.DELETE_FAILED, e);
		}
	}
}

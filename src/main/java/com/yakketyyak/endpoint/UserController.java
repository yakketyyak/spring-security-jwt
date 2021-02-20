package com.yakketyyak.endpoint;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakketyyak.dao.entity.UserEntity;
import com.yakketyyak.dao.repository.UserRepository;
import com.yakketyyak.dto.UserDto;
import com.yakketyyak.mapper.UserMapper;
import com.yakketyyak.validator.New;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserMapper userMapper;

	@PostMapping("/signup")
	public void signUp(@RequestBody @Validated(New.class) UserDto dto) {
		UserEntity entity = userMapper.toEntity(dto);

		entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		userRepository.save(entity);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAll() {

		List<UserEntity> users = userRepository.findAll();

		return ResponseEntity.status(HttpStatus.OK).body(userMapper.toDtos(users));

	}

}

package com.yakketyyak.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.yakketyyak.validator.New;
import com.yakketyyak.validator.NoXSSContent;
import com.yakketyyak.validator.Update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Positive(groups = { New.class, Update.class })
	private Integer id;

	@NotBlank(groups = { New.class, Update.class })
	@NoXSSContent(groups = { New.class, Update.class })
	private String username;

	@NotBlank(groups = { New.class, Update.class })
	@NoXSSContent(groups = { New.class, Update.class })
	private String password;

}

package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.string.StringHelper;

import ci.gouv.dgbf.system.cloture.server.api.service.ExerciseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Exercise extends AbstractObject implements Serializable {

	@JsonbProperty(value = ExerciseDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = ExerciseDto.JSON_CODE) private String code;	
	@JsonbProperty(value = ExerciseDto.JSON_NAME) private String name;
	@JsonbProperty(value = ExerciseDto.JSON_YEAR) private Short year;
	@JsonbProperty(value = ExerciseDto.JSON_YEAR_AS_STRING) String yearAsString;
	
	@Override
	public String toString() {
		return year == null ? (StringHelper.isBlank(name) ? code : name) : String.valueOf(year);
	}
}
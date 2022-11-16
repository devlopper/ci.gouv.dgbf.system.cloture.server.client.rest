package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.object.AbstractObject;

import ci.gouv.dgbf.system.cloture.server.api.service.ActivityDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Activity extends AbstractObject implements Serializable {

	@JsonbProperty(value = ActivityDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = ActivityDto.JSON_CODE) private String code;	
	@JsonbProperty(value = ActivityDto.JSON_NAME) private String name;
	
	@Override
	public String toString() {
		return code+" "+name;
	}
}
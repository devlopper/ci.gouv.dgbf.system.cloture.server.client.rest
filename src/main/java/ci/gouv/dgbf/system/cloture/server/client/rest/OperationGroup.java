package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.object.AbstractObject;

import ci.gouv.dgbf.system.cloture.server.api.service.OperationGroupDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class OperationGroup extends AbstractObject implements Serializable {

	@JsonbProperty(value = OperationGroupDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = OperationGroupDto.JSON_CODE) private String code;	
	@JsonbProperty(value = OperationGroupDto.JSON_NAME) private String name;
	
	@Override
	public String toString() {
		return name;
	}
}
package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.service.OperationTypeDto;
import ci.gouv.dgbf.system.cloture.server.api.service.OperationTypeService;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class OperationType extends AbstractObject implements Serializable {

	@JsonbProperty(value = OperationTypeDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = OperationTypeDto.JSON_CODE) private String code;	
	@JsonbProperty(value = OperationTypeDto.JSON_NAME) private String name;
	
	@Override
	public String toString() {
		return name;
	}
	
	public static OperationTypeService getService() {
		return (OperationTypeService) DependencyInjection.inject(SpecificServiceGetter.class).get(OperationType.class);
	}
}
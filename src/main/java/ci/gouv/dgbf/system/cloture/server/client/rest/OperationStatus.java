package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.service.OperationStatusDto;
import ci.gouv.dgbf.system.cloture.server.api.service.OperationStatusService;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class OperationStatus extends AbstractObject implements Serializable {

	@JsonbProperty(value = OperationStatusDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = OperationStatusDto.JSON_CODE) private String code;	
	@JsonbProperty(value = OperationStatusDto.JSON_NAME) private String name;
	
	@Override
	public String toString() {
		return name;
	}
	
	public static OperationStatusService getService() {
		return (OperationStatusService) DependencyInjection.inject(SpecificServiceGetter.class).get(OperationType.class);
	}
}
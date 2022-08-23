package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.service.OperationDto;
import ci.gouv.dgbf.system.cloture.server.api.service.OperationService;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Operation extends AbstractObject implements Serializable {

	private OperationType type;
	@JsonbProperty(value = OperationDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = OperationDto.JSON_CODE) private String code;	
	@JsonbProperty(value = OperationDto.JSON_NAME) private String name;
	@JsonbProperty(value = OperationDto.JSON_TYPE_AS_STRING) String typeAsString;
	@JsonbProperty(value = OperationDto.JSON_REASON) String reason;
	
	@Override
	public String toString() {
		return name;
	}
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_CODE = "code";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_TYPE_AS_STRING = "typeAsString";
	public static final String FIELD_REASON = "reason";
	
	public static OperationService getService() {
		return (OperationService) DependencyInjection.inject(SpecificServiceGetter.class).get(Operation.class);
	}
}
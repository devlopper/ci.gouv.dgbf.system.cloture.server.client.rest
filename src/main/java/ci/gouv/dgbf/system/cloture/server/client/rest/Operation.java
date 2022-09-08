package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;
import org.cyk.utility.service.client.entity.Color;

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
	@JsonbProperty(value = OperationDto.JSON_STATUS_CODE) String statusCode;
	@JsonbProperty(value = OperationDto.JSON_STATUS_AS_STRING) String statusAsString;
	@JsonbProperty(value = OperationDto.JSON_STARTED) Boolean started;
	@JsonbProperty(value = OperationDto.JSON_EXECUTED) Boolean executed;
	
	@JsonbProperty(value = OperationDto.JSON___AUDIT__) String __audit__;

	@JsonbProperty(value = OperationDto.JSON_COLOR) Color color;
	
	@Override
	public String toString() {
		return name;
	}
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_CODE = "code";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_TYPE_AS_STRING = "typeAsString";
	public static final String FIELD_REASON = "reason";
	public static final String FIELD_STATUS_AS_STRING = "statusAsString";
	public static final String FIELD___AUDIT__ = "__audit__";
	
	public static OperationService getService() {
		return (OperationService) DependencyInjection.inject(SpecificServiceGetter.class).get(Operation.class);
	}
}
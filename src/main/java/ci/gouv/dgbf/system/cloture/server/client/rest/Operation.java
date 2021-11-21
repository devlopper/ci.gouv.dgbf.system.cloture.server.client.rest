package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.persistence.OperationExecutionStatus;
import ci.gouv.dgbf.system.cloture.server.api.service.OperationDto;
import ci.gouv.dgbf.system.cloture.server.api.service.OperationService;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Operation extends AbstractObject implements Serializable {

	@JsonbProperty(value = OperationDto.JSON_IDENTIFIER) private String identifier;	
	@JsonbProperty(value = OperationDto.JSON_CODE) private String code;	
	@JsonbProperty(value = OperationDto.JSON_NAME) private String name;
	@JsonbProperty(value = OperationDto.JSON_START_DATE_NUMBER_OF_MILLISECOND) Long startDateNumberOfMillisecond;
	@JsonbProperty(value = OperationDto.JSON_START_DATE_STRING) String startDateString;
	@JsonbProperty(value = OperationDto.JSON_GROUP_IDENTIFIER) String groupIdentifier;
	@JsonbProperty(value = OperationDto.JSON_PROCEDURE_NAME) String procedureName;
	@JsonbProperty(value = OperationDto.JSON_TRIGGER) String trigger;	
	@JsonbProperty(value = OperationDto.JSON_EXECUTION_BEGIN_DATE_NUMBER_OF_MILLISECOND) Long executionBeginDateNumberOfMillisecond;
	@JsonbProperty(value = OperationDto.JSON_EXECUTION_BEGIN_DATE_STRING) String executionBeginDateString;
	@JsonbProperty(value = OperationDto.JSON_EXECUTION_END_DATE_NUMBER_OF_MILLISECOND) Long executionEndDateNumberOfMillisecond;
	@JsonbProperty(value = OperationDto.JSON_EXECUTION_END_DATE_STRING) String executionEndDateString;
	@JsonbProperty(value = OperationDto.JSON_EXECUTION_STATUS) OperationExecutionStatus executionStatus;
	
	@Override
	public String toString() {
		return name;
	}
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_CODE = "code";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_GROUP = "group";
	public static final String FIELD_GROUP_IDENTIFIER = "groupIdentifier";
	public static final String FIELD_START_DATE = "startDate";
	public static final String FIELD_START_DATE_STRING = "startDateString";
	public static final String FIELD_START_DATE_NUMBER_OF_MILLISECOND = "startDateNumberOfMillisecond";
	public static final String FIELD_PROCEDURE_NAME = "procedureName";
	public static final String FIELD_TRIGGER = "trigger";
	public static final String FIELD_EXECUTION_BEGIN_DATE = "executionBeginDate";
	public static final String FIELD_EXECUTION_BEGIN_DATE_STRING = "executionBeginDateString";
	public static final String FIELD_EXECUTION_BEGIN_DATE_NUMBER_OF_MILLISECOND = "executionBeginDateNumberOfMillisecond";
	public static final String FIELD_EXECUTION_END_DATE = "executionEndDate";
	public static final String FIELD_EXECUTION_END_DATE_STRING = "executionEndDateString";
	public static final String FIELD_EXECUTION_END_DATE_NUMBER_OF_MILLISECOND = "executionEndDateNumberOfMillisecond";
	public static final String FIELD_EXECUTION_STATUS = "executionStatus";
	
	public static OperationService getService() {
		return (OperationService) DependencyInjection.inject(SpecificServiceGetter.class).get(Operation.class);
	}
}
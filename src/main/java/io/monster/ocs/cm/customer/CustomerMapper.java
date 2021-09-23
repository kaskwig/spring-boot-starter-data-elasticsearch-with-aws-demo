package io.monster.ocs.cm.customer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDto(CustomerDocument customerDocument);
    CustomerDocument toDocument(CustomerDto customerDto);

    List<CustomerDto> toDtoList(List<CustomerDocument> customerDocument);
    List<CustomerDocument> toDocumentList(List<CustomerDto> customerDto);
}

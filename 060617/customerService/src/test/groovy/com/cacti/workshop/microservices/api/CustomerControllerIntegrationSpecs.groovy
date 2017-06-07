package com.cacti.workshop.microservices.api

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER
import static org.springframework.restdocs.payload.JsonFieldType.STRING
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import com.cacti.workshop.microservices.CustomerServiceApplication
import com.cacti.workshop.microservices.model.Customer
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.JUnitRestDocumentation
import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

/**
 * Created by domix on 9/17/16.
 */
@ContextConfiguration(classes = [CustomerServiceApplication])
@SpringBootTest(webEnvironment = RANDOM_PORT, value = ['management.port=0'])
class CustomerControllerIntegrationSpecs extends Specification {
  @Autowired
  WebApplicationContext context
  @Rule
  JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation('src/docs/generated-snippets')
  @Autowired
  ObjectMapper objectMapper
  MockMvc mockMvc

  public static final List<FieldDescriptor> PERSON_RESPONSE_DESCRIPTORS = [
    fieldWithPath('id')
      .type(STRING)
      .description('El identificador del cliente'),
    fieldWithPath('version')
      .type(NUMBER)
      .description('la version del registro del cliente'),
    fieldWithPath('lastModifiedAt')
      .type(STRING)
      .description('Fecha de modificacion'),
    fieldWithPath('name')
      .type(STRING)
      .description('Nombre del cliente'),
    fieldWithPath('createdAt')
      .type(STRING)
      .description('fecha de creacion'),
    fieldWithPath('email')
      .type(STRING)
      .description('Email del cliente'),
  ]

  public static final List<FieldDescriptor> PERSON_COMMAND_DESCRIPTORS = [
    fieldWithPath('id')
      .type(STRING)
      .description('El identificador del cliente'),
    fieldWithPath('version')
      .type(NUMBER)
      .description('la version del registro del cliente'),
    fieldWithPath('lastModifiedAt')
      .type(STRING)
      .description('Fecha de modificacion'),
    fieldWithPath('name')
      .type(STRING)
      .description('Nombre del cliente'),
    fieldWithPath('createdAt')
      .type(STRING)
      .description('fecha de creacion'),
    fieldWithPath('email')
      .type(STRING)
      .description('Email del cliente'),
  ]

  void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context)
      .apply(documentationConfiguration(restDocumentation)
      .uris().withScheme('http').withHost('localhost').withPort(8080))
      .build()
  }

  def 'should register a customer'() {
    given:
      def customer = new Customer(name: 'Domingo', email: 'domingo.suarez@yahoo.com')
      String json = objectMapper.writeValueAsString(customer)
    when:
      ResultActions result = mockMvc.perform(
        post('/v1/customer')
          .contentType(APPLICATION_JSON)
          .content(json)
      )

    then:
      result
        .andExpect(status().isOk())
        .andExpect(jsonPath('name').value('Domingo'))
        .andExpect(jsonPath('email').value('domingo.suarez@yahoo.com'))
        .andDo(document('v1-person/create',
        preprocessRequest(prettyPrint()),
        preprocessResponse(prettyPrint()),
        requestFields(PERSON_COMMAND_DESCRIPTORS),
        responseFields(PERSON_RESPONSE_DESCRIPTORS),
      ))
  }
}

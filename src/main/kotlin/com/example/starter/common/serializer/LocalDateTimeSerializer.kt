package com.example.starter.common.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.io.IOException
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class LocalDateTimeSerializer : StdSerializer<LocalDateTime>(LocalDateTime::class.java) {

	@Throws(IOException::class)
	override fun serialize(value: LocalDateTime?,
						   generator: JsonGenerator,
						   provider: SerializerProvider) {
		if (value != null) {
			val mills = value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
			generator.writeNumber(mills)
		} else {
			generator.writeNull()
		}
	}
}

class LocalDateTimeDeSerializer : StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {

		@Throws(IOException::class)
		override fun deserialize(parser: JsonParser,
								 context: DeserializationContext?): LocalDateTime {
			val value = parser.valueAsLong
			return LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault())
		}
}



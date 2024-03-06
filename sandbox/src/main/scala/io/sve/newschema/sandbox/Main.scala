package io.sve.newschema.sandbox

import SchemaUtils._

import org.apache.spark.sql.types.{DataType, IntegerType, StringType, StructField, StructType}


object Main extends App {

  // FIRST POSSIBLE USAGE

  case class MySchema(
    firstname: StructField = StructField("firstname", StringType),
    number: StructField = StructField("number", IntegerType)
  )

  object MySchema {
    val fields: MySchema = MySchema()
    val structType: StructType = getStructType(fields)
  }

  println("FIRST USAGE")
  println(s"${MySchema.fields.firstname}")
  MySchema.structType.foreach(sf => println(s" - $sf"))


  // ANOTHER POSSIBLE USAGE

  case class MonSchema(
    prenom: Field = Field("prénom", StringType, nullable = true, "ce qui est avant le nom"),
    age: Field = Field("age", IntegerType, nullable = true, "ce qui quantifie l'inquantifiable"),
  )

  object MonSchema {
    val fields: MonSchema = MonSchema()
    val structType: StructType = getStructType(fields)
  }

  println("SECOND USAGE")
  println(s"${MonSchema.fields.prenom}")
  MonSchema.structType.foreach(sf => println(s" - $sf"))

}

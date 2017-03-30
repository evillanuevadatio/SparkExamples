# Proyecto en Scala y SBT

## Crear un directorio donde se alojara tu proyecto scala/spark

``` 
 > mkdir WordsCount
``` 

## Crear estructura de directorios


``` 
 > cd WordsCount
 > mkdir -p src/main/scala
 > mkdir -p src/main/resources
 > mkdir -p src/main/scala/com/mx/datio
``` 

# Crear archivo plugins.sbt 
###### En este archivo  se agregaran las dependencias de nuestra app 

```
> vim plugins.sb

    name := "WordsCount"
    version := "1.0"
    scalaVersion := "2.11.0"
    libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "2.1.0"
```

## Crear clase scala donde

```
 > vim src/main/scala/com/mx/datio/WordsCount.scala
```

## Generar Jar
###### Esta operación podria tardar un poco ya que esta descargando las dependencias necesarias para compilar
```
 > sbt package
```


## Submit de tu aplicación

```
 >  spark-submit --class com.mx.datio.WordsCount --master spark://Geofront:7077 target/scala-2.11/wordscount_2.11-1.0.jar src/main/resources/README.md ~/tmp/WCScalaResult
```









# Crear y generar jar para ejecutar en spark.

## Generar Proyecto con mvn

```
# mvn archetype:generate
....
....
...
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains):  scala

7: remote -> net.alchim31.maven:scala-archetype-simple (The maven-scala-plugin is used for compiling/testing/running/documenting scala code in maven.)

Choose net.alchim31.maven:scala-archetype-simple version: 
1: 1.4
2: 1.5
3: 1.6
Choose a number: 3: 3

Define value for property 'groupId': com.mx.datio
Define value for property 'artifactId': MaxPrice
Define value for property 'version' 1.0-SNAPSHOT: :
Define value for property 'package' com.mx.datio: :

Confirm properties configuration:
groupId: com.mx.datio
artifactId: MaxPrice
version: 1.0-SNAPSHOT
package: com.mx.datio
 Y: : Y

```
## Entrar al proyecto 


```
cd MaxPrice

```
## Modificar el pom.xml

###### Se tiene que agregar la dependencia de spark en nuestro caso es la verion 2.1.0

```
    <dependency>
        <groupId>org.apache.spark</groupId>
        <artifactId>spark-core_2.10</artifactId>
        <version>2.1.0</version>
    </dependency>

```
###### La version actual de scala conla que contamos, en este caso ya esta la dependencia agregada solo hay que cambiar la version en el grupo de properies.

```
    <scala.version>2.11.0</scala.version>
```
###### Eliminar la propiedad en uno de los plugins

```
    <arg>-make:transitive</arg>
```

## Iniciar generación del jar


```
# mvn package
```

## Submit de la app 

```
# spark-submit --class com.mx.datio.MaxPrice --master spark://GeoFront:7077 target/MaxPrice-1.0-SNAPSHOT.jar src/main/resources/table.csv ~/tmp/Spark/output
```

## Definimos varios parametros al spark-submit:
###### Clase que tiene la funcionalidad o punto de acceso dentro de nuestro jar
```
--class com.mx.datio.MaxPrice  
```
###### Url del nodo Maestro de Spark el cual adminstra los recursos/task/jobs, en este caso mi maestro esta arriba con esos datos.
```
--master spark://GeoFront:7077 
```
###### Jar de nuestra apliación
```
target/MaxPrice-1.0-SNAPSHOT.jar 
```
###### Primer parametro de nuestra aplicación que es la fuente de nuestros datos, ruta absoluta del archivo de texto/csv
```
src/main/resources/table.csv
```
###### Segundo parametro de nuestra aplicación que es el destino  de nuestros datos procesados, ruta absoluta del directorio
```
~/tmp/Spark/output
```











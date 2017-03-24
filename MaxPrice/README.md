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

###### Iniciar generación del jar


```
# mvn package
```








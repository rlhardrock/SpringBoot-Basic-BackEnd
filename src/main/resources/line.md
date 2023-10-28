Create Database in the motor selected

Create the Connection Database in the GUI

Configure the document build.gradle, and reload with each dependency aggregated

Create and Configure the document application.yaml

Create Package "entities" inside create the entity -> Class ModelEntity

Create Package "repositories" inside create the repository -> Interface ModelRepository
this is DAO in others projects, then "extends JpaRepository <Model, Long>"
create the "finds" what do we need

Create Package "services" inside create the service -> Interface ModelService
create the "methods" what do we need

Create Package "implementations" inside create the implementation -> Class ModelImplementation
then "implements ModelService" and add @Autowired private ModelRepository modelRepository
add stereotype @Service

Create Package "controllers" inside create the control -> Class ModelController
add @RestController, @RequestMapping("/models") and add @Autowired private ModelService modelService
create all methods REST what do we need
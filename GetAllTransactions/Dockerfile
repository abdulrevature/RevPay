FROM public.ecr.aws/lambda/java:11

#the docker build command is running at my project root directory
COPY target/SpringWithLambda-0.0.1-SNAPSHOT-aws.jar ${LAMBDA_TASK_ROOT}/lib/

CMD ["org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"]

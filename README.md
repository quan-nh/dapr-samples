# Dapr Samples

[![Join the chat at https://gitter.im/Dapr/samples](https://badges.gitter.im/Dapr/samples.svg)](https://gitter.im/Dapr/samples?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This repository contains a series of samples that highlight Dapr capabilities. The first sample demonstrates how we run Dapr in standalone mode, while the second highlights how we run the same application in Kubernetes. Each subsequent sample includes instructions for running both in standalone and in Kubernetes.

| Sample                   | Description                                                                                                                                                                                    |
|--------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [1.hello-world](./1.hello-world)            | Demonstrates how to run Dapr locally. Highlights service invocation and state management.                                                                                                      |
| [2.hello-kubernetes](./2.hello-kubernetes)       | Demonstrates how to run Dapr in Kubernetes. Highlights service invocation and state management.                                                                                                |
| [3.grpc-app](./3.grpc-app) | Demonstrates grpc app. |
| [4.pub-sub](./4.pub-sub)                | Demonstrates how we use Dapr to enable pub-sub applications. Uses Redis as a pub-sub component.                                                                                          |
| [5.bindings](./5.bindings)            | Demonstrates how we use Dapr to create input and output bindings to other components. Uses bindings to Kafka.                                                                            |
| [6.functions-and-keda](./6.functions-and-keda) | Demonstrates use of Dapr pub/sub from Azure Functions, as well as composition with KEDA. |

To get started with the samples, clone this repository and follow instructions in each sample:
```bash
git clone https://github.com/dapr/samples.git
```

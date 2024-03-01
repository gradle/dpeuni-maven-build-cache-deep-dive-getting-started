# DPE University Training

[<img width="10%" height="10%" src="https://user-images.githubusercontent.com/120980/174325546-8558160b-7f16-42cb-af0f-511849f22ebc.png">](https://dpeuniversity.gradle.com/)
Checkout all the **free** Maven, Gradle, and DPE courses at the [DPE University][dpe-university]!

## Maven Build Cache Deep Dive - Lab 01: Getting Started

This is a hands-on exercise to go along with the [Maven Build Cache Deep Dive][course-url] training module. In this exercise you will go over the following:
 
- How to use a local build cache to speed up a Maven Build.
- Adding the Develocity Maven Extension to a project. 
- Basic usage of a build cache.

## Prerequisites

- Finished going through the _Local Build Cache_ section in Maven Build Cache Deep Dive.
- Java 11+

Steps
-----

1. Apply the latest version of the Develocity Maven Extension to the project.

   Run the command:
   ```shell
   ./mvnw com.gradle:develocity-maven-extension:1.21.4:init \
     -Ddevelocity.url=https://dpeuniversity-develocity.gradle.com
   ```
> [!NOTE]
> As part of taking this **free** course, you have access to a training instance of Develocity located at:
> ```
>  https://dpeuniversity-develocity.gradle.com/
>  ```
> [Sign in][develocity-url] to this Develocity server using the same account you use for the DPE University.
> 
> This server is configured so users can only access the Build Scan® and Build Cache entries they publish.
   
   See the [getting started guide](https://docs.gradle.com/enterprise/maven-extension/#getting_set_up) for details.

2. Create an access key to access the Develocity server.
   
   Run the command:
   ```shell
   ./mvnw com.gradle:develocity-maven-extension:1.21.4:provision-access-key
   ```

> [!TIP]
> For more ways to authenticate, see the [authentication guide](https://docs.gradle.com/enterprise/maven-extension/#authenticating_with_gradle_enterprise) to see how to provide credentials.

3. Configure the project to **only** use the local build cache. **Disable** the remote build cache.
   See how to set up `develocity.xml` in the [getting started guide](https://docs.gradle.com/enterprise/maven-extension/#getting_set_up).
   - See the [configuring the local cache](https://docs.gradle.com/enterprise/maven-extension/#configuring_the_local_cache) guide to configure local cache. (Enabled by default)
   - See the [disabling the remote cache](https://docs.gradle.com/enterprise/maven-extension/#disabling_the_remote_cache) guide to **disable** the remote cache.

4. Ensure local cache doesn't exist. Best way to do this is to delete `~/.m2/.develocity/build-cache`

    ```shell
    rm -rf ~/.m2/.develocity/build-cache
    ```

5. Build and run the application with local caching enabled. Enable debug logging for the build cache to see the details. The command is:
    
   ```shell
    ./mvnw clean verify exec:java -Dorg.slf4j.simpleLogger.log.develocity.goal.cache=debug
    ```
   
   On the first run, the build cache directory is created and populated with the outputs of the compilation operation. Identify the relevant log outputs.

6. Run again without changes. The log output contains two messages that indicated that the outputs were pulled from the cache. What would happen if you ran the same command multiple times?

7. What behavior would you expect if you deleted the directory `~/.m2/.develocity/build-cache` and re-ran the same command.
 
8. Configure the local cache to a non-standard directory and set the number of days that unused entries will be garbage collected to 30 days.
   - See the [local cache configuration](https://docs.gradle.com/enterprise/maven-extension/#changing_the_local_cache_directory) guide to set the directory. You can simply set it to `build-cache` which will create the cache directory in the current project.
   - See the [local cache cleanup](https://docs.gradle.com/enterprise/maven-extension/#Configuring_local_cache_cleanup) guide to set the cleanup `retention` and `interval` values.

## Solution Reference

To see the solution to the lab, check out the [`solution`](https://github.com/gradle/getting-started-maven-build-cache-lab/commit/solution) branch of this project.

## More Free Labs & Courses

Be sure to check out our other **free** [courses][dpe-university] and [labs](https://github.com/gradle?q=dpeuni)!

**Related courses:**
- [Maven - Build Cache Deep Dive][course-url]
- [Maven - Maintaining an Optimized Build Cache](https://dpeuniversity.gradle.com/c/42cf9d626302011526c4a0536b26af929b5bef58)
- [Develocity - How to Use Build Scans](https://dpeuniversity.gradle.com/c/0b0b3e4a8d21709ff39074e9962eee6ca4276dc1)

**Related labs:**
- [Lab 01 - Using the local build cache](https://github.com/gradle/getting-started-maven-build-cache-lab)
- [Lab 02 - Missing Inputs With Build Caching](https://github.com/gradle/missing-inputs-maven-build-cache-lab)
- [Lab 03 - Add Build Cache Support to any Maven Plugin](https://github.com/gradle/caching-any-plugin-maven-build-cache-lab)
- [Lab 04 - Handling Cache Misses with Normalization](https://github.com/gradle/cache-misses-maven-build-cache-lab)
- [Lab 05 - Outputs Overwrite Inputs](https://github.com/gradle/outputs-overwrite-inputs-maven-build-cache-lab)
- [Lab 06 - Maintaining an Optimized Build Cache](https://github.com/gradle/maintaining-optimized-cache-maven-build-cache-lab)

[course-url]: https://dpeuniversity.gradle.com/c/47262fea1e74b719afb590d8cb3f8280bf2af732
[dpe-university]: https://dpeuniversity.gradle.com/
[develocity-url]: https://dpeuniversity-develocity.gradle.com/
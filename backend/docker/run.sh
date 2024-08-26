#!/bin/bash

# This is a runner script to allow launching two background processes
# as the "CMD" of our container.

# Start the application. Netty can detect the changed
# class files and reload them.
./gradlew run &

# Start the gradle build server in watch mode.
# This will cause it to emit the compiled class
# files automatically on code change.
./gradlew -t :classes -x test -i &

# Wait until either ends.
wait -n

# Exit with its code.
exit $?

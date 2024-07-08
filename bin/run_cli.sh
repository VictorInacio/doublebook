#!/bin/bash

# Set the path to the project's root directory
PROJECT_DIR=$(dirname $(dirname $(realpath $0)))

# Change to the project's root directory
cd $PROJECT_DIR

# Run the Clojure program with the provided arguments
clj -M -m main "$@"

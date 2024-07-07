# doublebook
Calendar overlapping verification.
    
This program receives as input a collection of events and returns all overlapping as pairs.

## Run CLI demonstration
From the project root folder execute the following:

```bash
./bin/run_cli.sh ./example.json
```
You can edit the `./example.json` for different input or replace to the path of another desired file.

## Tests
To execute the tests run on terminal:

```bash

```

## Schema and Format
The input should 
Events should follow this format


## Dev mode

To start a Clojure repl run:

```bash
```
To load the namespace `double-books` and use the  `check-events-overlap` function:

``` clojure
(def events [ <event1> <event2> ...])

(check-events-overlap events)

=> Overlap event1 event2 from t1 to t2.
```

## Other usages

Any application can leverage the function `check-events-overlap` on API's or processing jobs once this
function receives clojure arrays as input.

For JSON processing there is a deserialization on the `run-cli` function.

           
                        


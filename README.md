# doublebook
Calendar overlapping verification.
    
This program receives as input a collection of events and returns all overlapping as pairs.

## Run CLI demonstration
From the project root folder execute the following:

```bash
./bin/run_cli.sh resources/example.edn
```
You can edit the `/resources/example.json` for different input or replace to the path of another desired file.

## Tests
To execute the tests run on terminal:

```bash
clj -X:test
```

## Dev mode

### Creating socket for remote REPL dev session
Firstly, install `clojure` package from [brew](https://formulae.brew.sh/formula/clojure) or your package manager.

```shell
clj -J-Dclojure.server.repl="{:port 5555 :accept clojure.core.server/repl}"
```

Use the function `double-book/find-overlapping-pairs`:

``` clojure
(def events [ <event1> <event2> ...])

(find-overlapping-pairs events)

=> Overlap event1 event2 from t1 to t2.
```

## Other usages

Any application can leverage the function `find-overlapping-pairs` on API's or processing jobs once this
function receives clojure arrays as input.

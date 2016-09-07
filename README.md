# warp-android-sdk
Android SDK for <a href="https://github.com/jakejosol/warp-server">warp-server</a>.

## Setup
Warp must be initialized **once** in your project.

```java
Warp.initialize(CONTEXT, BASE_URL, API_KEY);
```

## Usage 

```java
// Sample GET method

WarpObject object = new WarpObject.Builder()
        .setClassName("location")
        .find(new WarpCallback() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onSuccess(WarpResult result) {
                textView.setText(result.getResult().getCity());
            }
        });
```

Adding **pointer**

```java
addPointer(KEY, CLASSNAME, ID);
```

```java
// Sample POST method

WarpObject object = new WarpObject.Builder()
        .setClassName("location")
        .put("city", etCity.getText.toString())
        .addPointer("user", "user", getCurrentUser.getID())
        .save(new WarpCallback() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onSuccess(WarpResult result) {
                if (result.getStatus() == STATUS_SUCCESS) {
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT);
                }
            }
        });
```

For **PUT** method, use the overload save method

```java
save(ID, CALLBACK);
```

##Basic CRUD methods

| Method    | Java method               |
|-----------|---------------------------|
| GET       | find(callback)            |
| GET       | findById(id, callback)    |
| POST      | save(callback)            |
| PUT       | save(id, callback)        |
| DELETE    | destroy(id, callback)     

##User API

Logging In

```java
WarpUser.login(USERNAME, PASSWORD, CALLBACK);
```

Getting current user
```java
WarpUser.getCurrentUser();
```
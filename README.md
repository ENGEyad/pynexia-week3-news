# News App

A live Android news reader for technology, business and sports, with swipe refresh, image cards and source details.

Pynexia Android Development / Week 3.

[Hosted showcase](https://engeyad.github.io/pynexia-week3-news/) · [PDF report](https://github.com/ENGEyad/pynexia-week3-news/releases/latest/download/News-App-Report.pdf) · [APK](https://github.com/ENGEyad/pynexia-week3-news/releases/latest/download/news-debug.apk) · [Source ZIP](https://github.com/ENGEyad/pynexia-week3-news/releases/latest/download/News-App.zip)

## Implementation

### Live REST and JSON

Retrofit queries GDELT DOC for recent technology, business or sports coverage and parses the returned article list.

### News feed

RecyclerView cards show headline, source domain, date and a Glide-loaded image. Swipe down or switch category to refresh.

### Story details

Select a headline for a detail screen with source and date, then open the publisher’s original article.

## Build

JDK 17/21, Android SDK 35, Android 8.0/API 26 or newer. Initial dependency sync requires internet.

```powershell
.\gradlew.bat :news:assembleDebug :news:lintDebug
```

## Walkthrough

1. Select Technology, Business or Sports.
2. Pull down to refresh the live feed.
3. Tap an article card to view its source and publication date.
4. Open the publisher page for the full article.

## Verification

Debug build passed. Automated tests were not run. Lint reported 0 errors and 34 warnings; see `verification/`. Pixel 8 emulator, Android 17/API 37. No physical-device or API 26 review.

## Scope

Headlines and images depend on external publishers and the GDELT API. Network access is required for updates; availability, article images and coverage may vary. The app opens the source publisher for the complete article.

## References

- https://blog.gdeltproject.org/gdelt-doc-2-0-api-debuts/
- https://github.com/bumptech/glide

The hosted page displays screenshots and downloads; it is not an Android emulator.

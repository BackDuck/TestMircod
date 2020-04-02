package com.example.testmircod.service



class FirebaseService /*: FirebaseMessagingService() {

    companion object {
        const val ACTION_TYPE = "ACTION_TYPE"
        const val DATA_BUNDLE = "DATA_BUNDLE"
        const val PUSH_DATA = "PUSH_DATA"
        const val THREADS_ORIGIN = "threads"
        const val CHAT_ID = "-1"
    }


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        remoteMessage.data.let {
            val id: String?
            val title: String?
            val body: String?
            var payload = mutableMapOf<String, String>()

            if (it.contains("origin") && it["origin"] == THREADS_ORIGIN) {
                super.onMessageReceived(remoteMessage)
                id = CHAT_ID
                title = "Новое сообщение"
                body = it.getIfExist("alert")

            } else {

                id = it.getIfExist("id")
                title = it.getIfExist("title")
                body = it.getIfExist("body")

                payload = mutableMapOf<String, String>()

                if (it.containsKey("payload")) {
                    val p = it["payload"] ?: ""
                    if (p.isNotBlank()) {

                        val gType = object : TypeToken<Map<String, String>>() {}.type
                        val map: Map<String, String> = Gson().fromJson(p, gType)

                        payload.putAll(map)
                    }
                }

            }

            if (id != null && title != null && body != null) {
                sendNotification(PushData(id, title, body, payload))
            }
        }

    }

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onNewToken(token: String) {
        token?.let {
          *//*  setFirebaseTokenUseCase.setTokenCompletable(it)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i("FIREBASE", "Token added")
                },
                    {
                        it.printStackTrace()
                    })*//*
        }
    }

    private fun sendNotification(pushData: PushData) {

        val intent = Intent(this, RootActivity::class.java)
        intent.putExtra(PUSH_DATA, pushData)
        val pendingIntent = PendingIntent.getActivity(this, pushData.id.toInt(), intent, 0)

        val channelId = "HALVENOK_CHANEL_ID"
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notification_template_icon_bg)
            .setContentTitle(pushData.title)
            .setContentText(pushData.body)
            .setAutoCancel(true)
            .setSound(defaultSoundUri)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(pushData.id.toInt() *//* ID of notification *//*, notificationBuilder.build())
    }

}*/
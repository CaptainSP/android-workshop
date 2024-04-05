# Jetpack Compose

## Ön Tekrar
 - Kotlin, Java tabanlı, yazımı oldukça kolay güçlü ve güvenli bir
   programlama dilidir. Java tabanlı olduğu için Java'nın yapabileceği
   her şeyi yapabilir. 
  - Jetpack Compose ise, Kotlin dili ile yazılmış
   Android uygulama geliştirme freamwork'üdür.

## Nasıl Yazılır
Mobil geliştirmede tüm görsel elemanlarını (resim, yazı, tuşlar vs.) component diye adlandırabiliriz. Compose'da ise bu componentlere Composable diyoruz.

Kotlinin özellikleri sayesinde fonksiyonları iç içe yazabiliriz. Ve iç içe yazdığımız bu fonksiyonlarda her zaman parantez "()" kullanmamıza gerek yoktur. Compose da bu mantığa dayanır. Composable'ları iç içe yazarak bir hiyerarşi oluşturabilir ve özgürce uygulama geliştirebiliriz.

```kotlin
Column {  
  Text(  
        text = "Hello world!"  
  )  
}
```
Yukarıdaki bir örnek Composable kullanımıdır. Column aslında bir fonksiyondur ve içine Text Composable'ını almıştır. Ve gördüğünüz üzere Column fonksiyonunu çağırırken normal parantez kullanmaya gerek duymadık. Bu yapıyı tıpkı Java'daki ```if , else``` blokları gibi düşünebiliriz.

## Önizleme
Compose, otomatik yenilenen bir önizleme paneli sunar. Bu panelde anlık olarak yaptığınız tüm değşiklikleri görebilirsiniz.

Preview panelini kullanabilmek için;
```kotlin
@Preview(showBackground = true)  
@Composable  
fun PreviewAdi() {  
    UygulamaAdiTheme {  // Dark ve Light temalar için. 
		 Component() // İçeriğimiz
    }  
}
```
Yukarıdakine benzer bir kodu dosyamızın en altına eklememiz gerekir. Genellikle Android Studio bunu otomatik yapar.

## Compose'da Hiyerarşi

Compose'da üstteki gibi iç içe yazdığımız her Composable aşağıdaki gibi gözükür. Yani bir üsteki component bir alttakinin parent'ı diyebiliriz.
![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/ddf16021-02c7-40d6-4618-751ad2d9ac00/public)
## Ana Görüntü Elemanları
Compose'da componentleri olduğu gibi yazarsak hepsi üst üste binecektir. Bu yüzden aşağıdaki elemanları kullanarak componentlerimizi alt alta, yan yana veya birbirinin üstüne koyabiliriz.
 - Column ile componentleri alt alata koyabiliriz.
```kotlin
Column {  
  Component1 { }
  Component2 { }
  Component3 { }
}
```
![column](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/3c1e192a-02a1-4f34-7793-a5821bc6ce00/public)
 - Row ile componentleri yan yana koyabiliriz.
```kotlin
Row {  
  Component1 { }
  Component2 { }
}
```
![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/43da98ff-5e4a-4f3f-72e0-161c4efb2100/public)
 - Box ile componentleri üst üste bindirebiliriz.
 ```kotlin
 Box {  
  Component1 { }
  Component2 { }
}
```

![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/17591b1f-6498-4c98-3805-712890a1ec00/public)

## Modifier'lar
Modifier'lar adı üstünde component'lerimizi modifiye etmek için kullanılır. Modifier ile componentin boyutunu, rengini, pozisyonunu ve diğer stillerini değiştirebiliriz.

 - Örnek Kullanım
 ```kotlin
 Column(modifier = Modifier.padding(16.dp)) {
   Text(modifier = Modifier.fillMaxSize(), text = "Merhaba")
 }
 ```

Modifier'ları birleştirerek yazabiliriz.

 - Örnek kullanım
 ```kotlin
 Column(modifier = Modifier
                   .padding(16.dp)
                   .fillMaxSize()) {
   Text(modifier = Modifier.fillMaxSize(), text = "Merhaba")
 }
 ```

## Temel Modifier'lar

 - ```padding(size)``` ile component'in etrafına boşluk verebiliriz.
 - ```fillMaxWidth()``` ile component'in sağa ve sola doğru genişlemesini sağlayabiliriz.
 - ```fillMaxHeight()``` ile component'i dikey olarak büyültebiliriz.
 - ```background(color)``` ile arka plan rengi verebiliriz. Aynı component'e iç içe birden fazla arka plan rengi tanımlayabiliriz.
 - ```clickable { }``` ile component'e tıklama özelliği ekleyebiliriz.
# Temel Component'ler
## Text
```kotlin
Text(
 text = "Merhaba", // Metin içeriği
 modifier = Modifier.. // Modifier'lar
)
```
> Text, ekrana metin yerleştirmek için kullanılır.

## Button

```kotlin
Button(onClick = { /*TODO*/ }) {  
  Text(text = "Button metni")
}
```
> Button ile ekrana tuş koyabiliriz. Aşağıdaki gibi gözükecektir:

![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/34d81a92-0938-40e8-1c15-37d0029d3500/public)

## Card
```kotlin
Card() {        
  Text(text = "Hello, world!")    
}
```

> Card ile aşağıdaki gibi bir görüntü oluşturabiliriz.
![enter image description here](https://developer.android.com/static/develop/ui/compose/images/components/card.svg)

Aşağıdaki örnekte de Card'a arka plan renkleri tanımlayabiliriz.
```kotlin
Card( colors =  
	CardDefaults.cardColors( 
		containerColor =  MaterialTheme.colorScheme.surfaceVariant, // Arka plan rengini değiştirmek için 
	), 
	modifier =  
			Modifier
			.size(width =  240.dp, height =  100.dp)  // Card boyutunu belirtmek için
	)  { 
	 Text( // Klasik metin.
		 text =  "Filled", 
		 modifier =  Modifier
				.padding(16.dp), textAlign =  TextAlign.Center  
	)  
 }
```

> Yukarıdaki kod aşağıdaki gibi bir görsel oluşturacaktır.
![enter image description here](https://developer.android.com/static/develop/ui/compose/images/components/card-filled.png)

## Progress indicators
```kotlin
LinearProgressIndicator( 
	progress =  { currentProgress }, 
	modifier =  Modifier.fillMaxWidth(),  
)
```
> Yatay yükleniyor çubuğu oluşturmak için kullanılır.

```kotlin
CircularProgressIndicator( 
	modifier =  Modifier.width(64.dp), 
	color =  MaterialTheme.colorScheme.secondary, 
	trackColor =  MaterialTheme.colorScheme.surfaceVariant,  
)
```
> Dairesel yükleniyor çubuğu için kullanılır.
 <video width="320" height="100" controls>
 <source src="https://developer.android.com/static/develop/ui/compose/images/components/linear-indicator-determinate.mp4"></source>
</video>

## Scaffold
```kotlin
Scaffold(  
  
) { innerPadding ->
 // İçerik
}
```
> Scaffold, uygulamaya daha düzenli bir üst ve alt kısım verebileceğimiz çok amaçlı bir yapıdır. Bir çok farklı özelliği vardır. İlerideki ihtiyaçlarımız için mutlaka sayfamıza eklememiz gerekir. Genellikle hiyerarşinin en üstünde bulunur ve diğer component'leri içine alır.
```kotlin
Scaffold(  
    topBar = {  
	  TopAppBar(  
            colors = topAppBarColors(  // Renkleri belirtmek için
                containerColor = MaterialTheme.colorScheme.primaryContainer,  // Arka plan rengi
                titleContentColor = MaterialTheme.colorScheme.primary,// Yazı rengi  
            ),  
            title = {  
			  Text("Andorid Workshop")  // Üst Kısımdaki başlık
            }  
	  )  
    },  
     
) { innerPadding ->
// İçerik
}
```
> Bu yapı aşağıdaki gibi bir görüntü sunar:
> ![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/7b8a4c40-49f3-4b0f-1f92-86e265d13300/public)
```kotlin
Scaffold(  
    bottomBar = {  
	  BottomAppBar(  
            containerColor = MaterialTheme.colorScheme.primaryContainer,  // Arka plan rengi
            contentColor = MaterialTheme.colorScheme.primary,  // İçerik rengi
        ) {  
	  Text(  
                modifier = Modifier  
                    .fillMaxWidth(),  
                textAlign = TextAlign.Center,  
                text = "Bottom app bar",  
            )  
        }  
 },  
  
) { innerPadding ->
// İçerik
}
```
> Bu şekilde ise alt tarafa bir kısım belirtebiliriz.
> ![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/00757aeb-1f0a-4f94-6625-eaba68e60c00/public)

```kotlin
Scaffold(  
    floatingActionButton = {  
	  FloatingActionButton(onClick = { /* Tıklayınca ne yapcağız */  }) {  
		  Icon(Icons.Default.Add, contentDescription = "Add")  // Butona ikon ekleyebilmek için
        }  
 }) { innerPadding ->
 // İçerik
 }
```

> Bu şekilde bir kayan buton ekleyebiliriz. Bu butonun özelliği sağ alt köşede hep sabit kalmasıdır.
![enter image description here](https://imagedelivery.net/zXnUW6xH7ShY8uLqKXhSHw/6edf9ba4-5e03-40b9-0658-9a3fa1d24b00/public)

> **Not:** Tüm bu üstteki yapıları tek bir Scaffold içinde birlikte kullanabiliriz.

## Dialog

```kotlin
@OptIn(ExperimentalMaterial3Api::class) // Uyarıları gizlemek için
@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit, // Dialog kapatıldığında çağrılır
    onConfirmation: () -> Unit, // "Tamam" butonuna tıklayınca çağrılır
    dialogTitle: String,  // Bailık
    dialogText: String, // İç metin
    icon: ImageVector, // Dialog ikonu
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon") // Üstten aldığımız ikonu giriyoruz
        },
        title = {
            Text(text = dialogTitle) // Üstten aldığımız title
        },
        text = {
            Text(text = dialogText) // Üstten aldığımız içerik
        },
        onDismissRequest = {
            onDismissRequest() // Üstteki fonksiyonu çağırır
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation() // Tamam butonu
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest() // İptal Butonu
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
```

- Dialog'u gösterme
```kotlin
 val openAlertDialog = remember { mutableStateOf(false) } // İçindeki değeri sayfaya yenilense de değiştirmemeyi sağlar.

    // ...
        when { // Kotlinin bir özelliğidir. If gibi çalışır.
            // ...
            openAlertDialog.value -> {
                AlertDialogExample(
                    onDismissRequest = { openAlertDialog.value = false },
                    onConfirmation = {
                        openAlertDialog.value = false // Dialog'u tekrar gizlemek için
                        // Başka ne yapmak istiyorsak...
                    },
                    dialogTitle = "Alert dialog example", // Başlık
                    dialogText = "This is an example of an alert dialog with buttons.", // İç metin
                    icon = Icons.Default.Info // Icon'umuz
                )
            }
        }
    }
```

## TextField
```kotlin
var text by remember { mutableStateOf("") } // Yazılan metni saklamak için kullanıyoruz.

// Normal Text Field
TextField(
    value = text,
    onValueChange = { text = it }, // Metin girildikçe üstteki text değişkenini değiştiriyoruz
    label = { Text("Label") }
)

// Çerçeveli Text Field
OutlinedTextField(
	 value = text,
	 onValueChange = { text = it }, // Metin girildikçe üstteki text değişkenini değiştiriyoruz
	 label = { Text("Label") }
)    

```

![enter image description here](https://developer.android.com/static/develop/ui/compose/images/text-textfield-hello.png)
Normal TextField

![enter image description here](https://developer.android.com/static/develop/ui/compose/images/text-outlinedtextfield.png)
Çerçeveli TextField

## LazyList
Android'de Ram kullanımı çok önemlidir. Eğer tüm liste elemanlarını aynı anda gösterirsek (Örneğin 1000 uzunluğu olan bir liste) uygulamamız çökecektir. Bunu önlemek için ```LazyColumn``` kullanırız. Görsel olarak `Column` gibi çalışır. Sadece içindeki elemanlar kaydırdıkça parça parça yüklenir.

```kotlin
LazyColumn {
    // Tek bir eleman ekler
    item {
        Text(text = "First item") // İçine başka şeyler de koyabiliriz. Text olmak zorunda değil.
    }

    // 5 Eleman birden ekler
    items(5) { index ->
        Text(text = "Item: $index")
    }

    // Başka bir tek eleman ekledik.
    item {
        Text(text = "Last item")
    }
}
```

# State Yönetimi
Gerçek hayatta yaptığımız uygulamalarda her zaman tüm component'ler sabit kalmıyor. Bazen metinlerimizin içeriği veya renkleri gibi özelliklerini, veya diğer component'lerin özelliklerini dinamik olarak değiştirmemiz gerekebiliyor. 

Compose sistemini bu değişiklikleri söylemek için `remember` ve `state` 'leri kullanıyoruz.

En çok kullandığımız State methodu `mutableStateOf`'dur. `mutableStateOf` ile tanımladığımız değişkenin takip edilmesi gerektiğini söylüyoruz. Yani `mutableStateOf` kullandığımızda Compose sistemi, bizim değişkenimizin ne zaman değiştiğini bilebilir ve buna göre component'leri de yeni halleri ile tekrar gösterebilir.

Fakat `@Composable` ile belirttiğimiz fonksiyonlar her çizim sırasında tekrar çalıştıkları için içlerine yazdığımız bu değişkenleri kaybedebiliriz. Bu değişiklikleri kaybetmemek için de `remember` methodunu kullanıyoruz.

## Örnek Kullanım
```kotlin
var metin by remember { // Değişkenimizi remember ile kaydettik
	mutableStateOf("henüz değişmedim") // Değişkenimizi state ile belirledik
}  
  
Column {  
  Text(text = "Süreyya hanım: $metin")  // metin her değiştiğinde Compose fonksiyonumuzu yeni haliyle tekrar çalıştıracak.
    Button(onClick = {
	    metin = "Ben çok değiştim" // Değişkenimizi burada dinamik olarak değiştiriyoruz 
	}) {  
	   Text(text = "Tıkla")
  }  
}
```
![enter image description here](https://i.ibb.co/bsGBjqb/ezgif-2-aa5ed17d49.gif)

Görselde gördüğünüz gibi butona tıklayınca metnimiz değişti.
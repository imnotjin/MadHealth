import sys
import requests
import json

# Set up API key and endpoint URLs
API_KEY = 'iozvUIs2rWYXQ2lfItOoCcb3fXc3zMbaHEmR2tgZ'
SEARCH_ENDPOINT = 'https://api.nal.usda.gov/fdc/v1/search'
NUTRITION_ENDPOINT = 'https://api.nal.usda.gov/fdc/v1/{food_id}'
Calories = 0
carbs = 0
cho = 0
pro = 0
bf = 0
# Get the food item from the user
NAME = input("Enter your name")
Age = int(input("Enter your age"))
Weight = int(input("Enter your weight in kilograms"))
Height = int(input("Enter your height in centimeters"))
gender = input("Enter m or f for your gender")

print("Your daily intake will be calculated")
food_item ='a'
while food_item != "exit":
    # Make a search request to find the FDC ID for the food item
    food_item = input('Enter a food item, or enter "exit" to go finish: ')
    if food_item == 'exit':
        break
    params = {'api_key': API_KEY, 'generalSearchInput': food_item}
    response = requests.get(SEARCH_ENDPOINT, params=params)
    data = json.loads(response.text)
    if len(data['foods']) == 0:
        print("The food you are looking for is not in the database")
        sys.exit(1)
    else:
        fdc_id = data['foods'][0]['fdcId']

# Make a nutrition request to obtain the nutritional information for the food item
    url = NUTRITION_ENDPOINT.format(food_id=fdc_id)
    params = {'api_key': API_KEY}
    response = requests.get(url, params=params)
    data = json.loads(response.text)

# Extract the relevant nutritional information from the response
    nutrients = data['foodNutrients']
    sorted_Nutrients = sorted(nutrients, key=lambda d: d['nutrient']['name'])
    s = float(input("enter number of servings "))
    print("nutritional information for food for 1 serving")
    for i in range(len(nutrients)):
        name = sorted_Nutrients[i]['nutrient']['name']
        value = sorted_Nutrients[i].get('amount', 0)
        unit = sorted_Nutrients[i]['nutrient']['unitName']
        if name == 'Energy':
            Calories = value*s+Calories
        if name == 'Carbohydrate, by difference':
            carbs = value*s + carbs
        if name == 'Cholesterol':
            cho = value*s + cho
        if name == 'Protein':
            pro = value*s + pro
        if name == ('Fatty acids, total saturated' or 'Fatty acids, total trans'):
            bf = value*s + bf
        print(f'{name}: {value} {unit}')
print("total carbs "+str(carbs)+"g")
print("total calories "+str(Calories)+"Kcal")
print("Total Cholesterol "+str(cho)+"mg")
print("Total Protein "+str(pro)+"g")
print("Unhealthy fats "+str(bf)+"g")
print("Hey,"+NAME)
if 0.07*Calories < 9*bf:
    print("You must decrease your intake of saturated and trans fatty acids")
elif gender == 'm':
    if((9.99*Weight)+(6.25*Height)-(4.92*Age)+5) < Calories:
        print("You are overeating your calories")
        eat = ((9.99*Weight)+(6.25*Height)-(4.92*Age)+5)
        print("You must eat "+str(eat))
    else:
        print("you are all good")
elif gender == 'f':
    if ((9.99 * Weight) + (6.25 * Height) - (4.92 * Age)-161) < Calories:
        print("You are overeating your calories")
        eat = ((9.99 * Weight) + (6.25 * Height) - (4.92 * Age)-161)
        print("You must eat " + str(eat))
    else:
        print("you are all good")
else:
    print("you are all good")

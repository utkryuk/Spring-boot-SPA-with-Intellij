# FROM node:latest as build-step

# WORKDIR /usr/local/app 

# COPY ./ /usr/local/app/

# RUN npm install

# RUN npm run build

# FROM nginx:latest

# COPY --from= build /usr/local/app/dist/frontend /usr/share/nginx/html

# EXPOSE 80

FROM node:latest as build-step

RUN mkdir -p /app

WORKDIR /app

COPY package.json /app

RUN npm install

COPY . /app

RUN npm run build --prod

FROM nginx:latest

COPY --from=build-step /app/dist/frontend /usr/share/share/nginx/html